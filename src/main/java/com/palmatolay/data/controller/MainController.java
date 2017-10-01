package com.palmatolay.data.controller;

import com.palmatolay.data.entity.Room;
import com.palmatolay.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RestController
public class MainController {

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = "rooms", method = RequestMethod.GET)
    List<Room> findAll(@RequestParam(required = false) String roomNumber) {
        List<Room> rooms = new ArrayList<>();
        if(roomNumber==null) {
            Iterable<Room> results = this.roomRepository.findAll();
            results.forEach(rooms::add);
        } else {
            Room room = this.roomRepository.findAllByNumber(roomNumber);
            if(room!=null)
                rooms.add(room);
        }
        return rooms;
    }
}
