package org.veromatrix.trackme.logservice.web.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.veromatrix.trackme.logservice.entity.LogEntry;
import org.veromatrix.trackme.logservice.entity.Metadata;
import org.veromatrix.trackme.logservice.transfer.LogEntryTO;
import org.veromatrix.trackme.logservice.transfer.MetadataTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-16T20:48:27-0400",
    comments = "version: 1.6.1, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class LogEntryMapperImpl implements LogEntryMapper {

    @Override
    public LogEntry mapToEntity(LogEntryTO entryTO) {
        if ( entryTO == null ) {
            return null;
        }

        LogEntry logEntry = new LogEntry();

        if ( entryTO.getTimestamp() != null ) {
            logEntry.setTimestamp( entryTO.getTimestamp() );
        }
        else {
            logEntry.setTimestamp( java.time.Instant.now().getEpochSecond() );
        }
        if ( entryTO.getActive() != null ) {
            logEntry.setActive( entryTO.getActive() );
        }
        else {
            logEntry.setActive( true );
        }
        if ( entryTO.getMetadata() != null ) {
            logEntry.setMetadata( mapToEntity( entryTO.getMetadata() ) );
        }
        else {
            logEntry.setMetadata( new Metadata() );
        }
        logEntry.setId( entryTO.getId() );
        logEntry.setEntryId( entryTO.getEntryId() );
        logEntry.setDay( entryTO.getDay() );
        logEntry.setCategory( entryTO.getCategory() );
        logEntry.setSubCategory( entryTO.getSubCategory() );
        logEntry.setContent( entryTO.getContent() );
        List<String> list = entryTO.getTags();
        if ( list != null ) {
            logEntry.setTags( new ArrayList<String>( list ) );
        }

        return logEntry;
    }

    @Override
    public List<LogEntry> mapToEntityAsList(List<LogEntryTO> entryTO) {
        if ( entryTO == null ) {
            return null;
        }

        List<LogEntry> list = new ArrayList<LogEntry>( entryTO.size() );
        for ( LogEntryTO logEntryTO : entryTO ) {
            list.add( mapToEntity( logEntryTO ) );
        }

        return list;
    }

    @Override
    public List<LogEntryTO> mapFromEntityAsList(List<LogEntry> entryTO) {
        if ( entryTO == null ) {
            return null;
        }

        List<LogEntryTO> list = new ArrayList<LogEntryTO>( entryTO.size() );
        for ( LogEntry logEntry : entryTO ) {
            list.add( mapFromEntity( logEntry ) );
        }

        return list;
    }

    @Override
    public LogEntryTO mapFromEntity(LogEntry entryTO) {
        if ( entryTO == null ) {
            return null;
        }

        LogEntryTO logEntryTO = new LogEntryTO();

        logEntryTO.setId( entryTO.getId() );
        logEntryTO.setDay( entryTO.getDay() );
        logEntryTO.setEntryId( entryTO.getEntryId() );
        logEntryTO.setTimestamp( entryTO.getTimestamp() );
        logEntryTO.setCategory( entryTO.getCategory() );
        logEntryTO.setSubCategory( entryTO.getSubCategory() );
        logEntryTO.setContent( entryTO.getContent() );
        List<String> list = entryTO.getTags();
        if ( list != null ) {
            logEntryTO.setTags( new ArrayList<String>( list ) );
        }
        logEntryTO.setMetadata( mapFromEntity( entryTO.getMetadata() ) );
        logEntryTO.setActive( entryTO.getActive() );

        return logEntryTO;
    }

    @Override
    public Metadata mapToEntity(MetadataTO metadataTO) {
        if ( metadataTO == null ) {
            return null;
        }

        Metadata metadata = new Metadata();

        metadata.setMood( metadataTO.getMood() );
        metadata.setLocation( metadataTO.getLocation() );
        metadata.setSource( metadataTO.getSource() );
        metadata.setConfidence( metadataTO.getConfidence() );

        return metadata;
    }

    @Override
    public MetadataTO mapFromEntity(Metadata metadata) {
        if ( metadata == null ) {
            return null;
        }

        MetadataTO metadataTO = new MetadataTO();

        metadataTO.setMood( metadata.getMood() );
        metadataTO.setLocation( metadata.getLocation() );
        metadataTO.setSource( metadata.getSource() );
        metadataTO.setConfidence( metadata.getConfidence() );

        return metadataTO;
    }

    @Override
    public LogEntry mergeToEntity(LogEntryTO param, LogEntry entry) {
        if ( param == null ) {
            return entry;
        }

        if ( param.getId() != null ) {
            entry.setId( param.getId() );
        }
        if ( param.getEntryId() != null ) {
            entry.setEntryId( param.getEntryId() );
        }
        if ( param.getDay() != null ) {
            entry.setDay( param.getDay() );
        }
        if ( param.getTimestamp() != null ) {
            entry.setTimestamp( param.getTimestamp() );
        }
        if ( param.getCategory() != null ) {
            entry.setCategory( param.getCategory() );
        }
        if ( param.getSubCategory() != null ) {
            entry.setSubCategory( param.getSubCategory() );
        }
        if ( param.getContent() != null ) {
            entry.setContent( param.getContent() );
        }
        if ( entry.getTags() != null ) {
            List<String> list = param.getTags();
            if ( list != null ) {
                entry.getTags().clear();
                entry.getTags().addAll( list );
            }
        }
        else {
            List<String> list = param.getTags();
            if ( list != null ) {
                entry.setTags( new ArrayList<String>( list ) );
            }
        }
        if ( param.getMetadata() != null ) {
            entry.setMetadata( mapToEntity( param.getMetadata() ) );
        }
        if ( param.getActive() != null ) {
            entry.setActive( param.getActive() );
        }

        return entry;
    }
}
