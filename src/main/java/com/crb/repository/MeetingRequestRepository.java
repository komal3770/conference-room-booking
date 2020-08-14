package com.crb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crb.entity.MeetingRequest;
@Repository
public interface MeetingRequestRepository extends JpaRepository<MeetingRequest, Integer>{
	
	
	/**
	 * @return Get meeting request in descending order of duration
	 * */
	@Query("FROM MeetingRequest ORDER BY duration desc")
	List<MeetingRequest> findAllOrdered();
}
