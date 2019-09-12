package com.comakeit.mrbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comakeit.mrbs.entity.MeetingRoom;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {

}
