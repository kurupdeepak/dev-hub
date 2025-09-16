package org.veromatrix.trame.entryservice.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.veromatrix.trame.entryservice.transfer.LogEntryTO;
import org.veromatrix.trame.entryservice.web.service.LogEntryService;
import org.veromatrix.trame.entryservice.web.service.LogEntryServiceImpl;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trame/api/entries")
public class LogEntryController {
    private final LogEntryService service;

    public LogEntryController(LogEntryServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<LogEntryTO> getAll(LocalDate day){ return null;};

    @GetMapping("/{log-id}")
    public ResponseEntity<LogEntryTO> getEntry(@PathVariable("log-id") String logId)
    {
        return ResponseEntity.ok().body(service.getEntry(logId));
    };

    @PostMapping
    public ResponseEntity<LogEntryTO> saveEntry(@RequestBody LogEntryTO entry){
        LogEntryTO logEntryTO = service.saveEntry(entry);
        return ResponseEntity.created(URI.create("/" + logEntryTO.getEntryId())).body(logEntryTO);
    }

    @PutMapping("/{log-id}")
    public ResponseEntity<LogEntryTO> updateEntry(@PathVariable("log-id") String logId,@RequestBody LogEntryTO entry){
        LogEntryTO logEntryTO = service.updateEntry(logId, entry);
        return ResponseEntity.accepted().body(logEntryTO);
    }

    @PatchMapping("/{log-id}")
    public ResponseEntity<LogEntryTO> patchEntry(@PathVariable("log-id") String logId,@RequestBody LogEntryTO entry){
        LogEntryTO logEntryTO = service.patchEntry(logId, entry);
        return ResponseEntity.ok(logEntryTO);
    }

    @DeleteMapping("/{log-id}")
    public ResponseEntity<String> deleteEntry(@PathVariable("log-id") String logId){
        boolean deleted = service.deleteEntry(logId);
        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.unprocessableEntity().build();
    }
}
