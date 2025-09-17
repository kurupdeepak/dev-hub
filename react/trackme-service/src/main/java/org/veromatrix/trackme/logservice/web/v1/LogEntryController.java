package org.veromatrix.trackme.logservice.web.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.veromatrix.trackme.logservice.transfer.LogEntryTO;
import org.veromatrix.trackme.logservice.web.service.LogEntryService;
import org.veromatrix.trackme.logservice.web.service.LogEntryServiceImpl;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/trackme/v1/log-entries")
public class LogEntryController {
    private final LogEntryService service;

    public LogEntryController(LogEntryServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<LogEntryTO> getAll(LocalDate day){ return null;};

    @GetMapping("/{entry-id}")
    public ResponseEntity<LogEntryTO> getEntry(@PathVariable("entry-id") String logId)
    {
        return ResponseEntity.ok().body(service.getEntry(logId));
    };

    @PostMapping
    public ResponseEntity<LogEntryTO> saveEntry(@RequestBody LogEntryTO entry){
        LogEntryTO logEntryTO = service.saveEntry(entry);
        return ResponseEntity.created(URI.create("/" + logEntryTO.getEntryId())).body(logEntryTO);
    }

    @PutMapping("/{entry-id}")
    public ResponseEntity<LogEntryTO> updateEntry(@PathVariable("entry-id") String logId,@RequestBody LogEntryTO entry){
        LogEntryTO logEntryTO = service.updateEntry(logId, entry);
        return ResponseEntity.accepted().body(logEntryTO);
    }

    @PatchMapping("/{entry-id}")
    public ResponseEntity<LogEntryTO> patchEntry(@PathVariable("entry-id") String logId,@RequestBody LogEntryTO entry){
        LogEntryTO logEntryTO = service.patchEntry(logId, entry);
        return ResponseEntity.ok(logEntryTO);
    }

    @DeleteMapping("/{entry-id}")
    public ResponseEntity<String> deleteEntry(@PathVariable("entry-id") String logId){
        boolean deleted = service.deleteEntry(logId);
        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.unprocessableEntity().build();
    }
}
