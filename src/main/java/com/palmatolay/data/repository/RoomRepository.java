package com.palmatolay.data.repository;

import com.palmatolay.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    Room findAllByNumber(String number);
}
