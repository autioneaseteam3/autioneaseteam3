package com.trade.autioneaseproject.restcontroller;

import com.trade.autioneaseproject.entity.Warehouse;
import com.trade.autioneaseproject.request.ApiResponse;
import com.trade.autioneaseproject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseRestController {
    @Autowired
    private WarehouseService warehouseService;
    @GetMapping("/get-all")
    public ApiResponse<List<Warehouse>> getAll(){
        ApiResponse<List<Warehouse>> apiResponse = new ApiResponse<>();
        List<Warehouse> warehouses = warehouseService.getAll();

        if (warehouses != null){
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setMessage("Get all warehouse success");
            apiResponse.setData(warehouses);
        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("Get all warehouse failed");
            apiResponse.setData(null);
        }
        return apiResponse;
    }

    @GetMapping("/get-one/{id}")
    public ApiResponse<Warehouse> getOne(@PathVariable("id") Integer id){
        ApiResponse<Warehouse> apiResponse = new ApiResponse<>();
        Warehouse warehouse = warehouseService.getOne(id);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setMessage("Get warehouse success");
        apiResponse.setData(warehouse);

        return apiResponse;
    }

    @PostMapping("/create")
    public ApiResponse<Warehouse> create(@RequestBody Warehouse request){
        ApiResponse<Warehouse> apiResponse = new ApiResponse<>();
        Warehouse warehouse = warehouseService.create(request);

        if (warehouse != null){
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setMessage("Create warehouse success");
            apiResponse.setData(warehouse);
        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("Create warehouse failed");
            apiResponse.setData(null);
        }
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<Warehouse> update(@PathVariable("id") Integer id, @RequestBody Warehouse request){
        ApiResponse<Warehouse> apiResponse = new ApiResponse<>();
        Warehouse warehouse = warehouseService.update(id, request);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setMessage("Update warehouse success");
        apiResponse.setData(warehouse);

        return apiResponse;
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Boolean> delete(@PathVariable("id") Integer id){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        warehouseService.delete(id);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setMessage("Delete warehouse success");
        apiResponse.setData(null);

        return apiResponse;
    }
}