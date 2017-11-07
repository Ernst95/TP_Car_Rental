package com.tpCarRental.controller;

import com.google.gson.Gson;
import com.tpCarRental.domain.Status;
import com.tpCarRental.factories.StatusFactory;
import com.tpCarRental.services.Impl.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/tpCarRental")
public class StatusController {

    @Autowired
    private StatusServiceImpl statusService;

    @GetMapping(path = "/addStatus/{statusId}/{statuses}")
    public @ResponseBody
    String addStatus(@PathVariable String statusId, @PathVariable String statuses)
    {
        Status Status = StatusFactory.buildStatus(statusId, statuses);
        statusService.save(Status);
        return new Gson().toJson(Status);
    }

    @GetMapping(path = "readStatus/{statusId}")
    public @ResponseBody String readstatus(@PathVariable String statusId)
    {
        Status Status = statusService.findById(statusId);
        return new Gson().toJson(Status);
    }

    @GetMapping(path = "/updateStatus/{statusId}/{statuses}")
    public @ResponseBody String updatestatus(@PathVariable String statusId, @PathVariable String statuses)
    {
        Status Status = statusService.findById(statusId);

        if(Status == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Status statusInsert = StatusFactory.buildStatus(statusId, statuses);
        statusService.update(statusInsert);
        return new Gson().toJson(statusInsert);
    }

    @GetMapping(path = "deleteStatus/{statusId}")
    public @ResponseBody void deletestatus(@PathVariable String statusId) {
        Status Status = statusService.findById(statusId);
        if (Status == null) {
            System.out.println("Record does not exist");
        } else {
            statusService.delete(Status);
            System.out.println("Record deleted");
        }
    }
}
