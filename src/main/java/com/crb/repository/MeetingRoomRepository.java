package com.crb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crb.entity.MeetingRoom;
@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer>{

}
