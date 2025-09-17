package org.veromatrix.trackme.logservice.web.mapper;

import org.mapstruct.*;
import org.veromatrix.trackme.logservice.entity.LogEntry;
import org.veromatrix.trackme.logservice.entity.Metadata;
import org.veromatrix.trackme.logservice.transfer.LogEntryTO;
import org.veromatrix.trackme.logservice.transfer.MetadataTO;
import org.veromatrix.trackme.logservice.web.EntryServiceException;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogEntryMapper {
    @Mapping(source="timestamp" , target = "timestamp",defaultExpression ="java(java.time.Instant.now().getEpochSecond())")
    @Mapping(source = "active", target = "active",defaultValue = "true")
    @Mapping(source = "metadata", target = "metadata",defaultExpression = "java(new Metadata())")
    LogEntry mapToEntity(LogEntryTO entryTO);

    List<LogEntry> mapToEntityAsList(List<LogEntryTO> entryTO);

    List<LogEntryTO> mapFromEntityAsList(List<LogEntry> entryTO);

    LogEntryTO mapFromEntity(LogEntry entryTO);

    Metadata mapToEntity(MetadataTO metadataTO);

    MetadataTO mapFromEntity(Metadata metadata);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LogEntry mergeToEntity(LogEntryTO param, @MappingTarget LogEntry entry);

    default LogEntry patchToEntity(LogEntryTO param, LogEntry entry) {
        if (param == null || entry == null) {
            throw new EntryServiceException("Null provided for patchToEntity");
        }
        if (param.getCategory() != null) {
            entry.setCategory(param.getCategory());
        }
        if (param.getSubCategory() != null) {
            entry.setSubCategory(param.getSubCategory());
        }

        if (param.getContent() != null) {
            entry.setContent(param.getContent());
        }
        return entry;
    }
}