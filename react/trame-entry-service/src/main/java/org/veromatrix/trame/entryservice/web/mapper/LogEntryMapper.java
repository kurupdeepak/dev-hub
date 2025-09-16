package org.veromatrix.trame.entryservice.web.mapper;

import org.mapstruct.Mapper;
import org.veromatrix.trame.entryservice.entity.LogEntry;
import org.veromatrix.trame.entryservice.transfer.LogEntryTO;
import org.veromatrix.trame.entryservice.web.EntryServiceException;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogEntryMapper {
    LogEntry mapToEntity(LogEntryTO entryTO);

    List<LogEntry> mapToEntityAsList(List<LogEntryTO> entryTO);

    List<LogEntryTO> mapFromEntityAsList(List<LogEntry> entryTO);

    LogEntryTO mapFromEntity(LogEntry entryTO);

    LogEntry mergeToEntity(LogEntryTO param, LogEntry entry);

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