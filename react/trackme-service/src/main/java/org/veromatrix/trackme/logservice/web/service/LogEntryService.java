package org.veromatrix.trackme.logservice.web.service;

import org.veromatrix.trackme.logservice.transfer.LogEntryTO;

import java.time.LocalDate;
import java.util.List;

public interface LogEntryService {
    List<LogEntryTO> getAllEntries(LocalDate day);

    LogEntryTO getEntry(String logId);

    LogEntryTO saveEntry(LogEntryTO entry);

    LogEntryTO updateEntry(String logId, LogEntryTO entry);

    LogEntryTO patchEntry(String logId, LogEntryTO entry);

    boolean deleteEntry(String logId);
}
