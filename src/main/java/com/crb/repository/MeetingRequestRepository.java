package com.crb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crb.entity.MeetingRequest;
@Repository
public interface MeetingRequestRepository extends JpaRepository<MeetingRequest, Integer>{

}
