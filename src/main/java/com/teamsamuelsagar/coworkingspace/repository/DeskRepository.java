package com.teamsamuelsagar.coworkingspace.repository;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.Desk;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {
    List<Desk> findByOfficeId(Long officeId);

    @Query("""
            SELECT d FROM Desk d WHERE d.office.id = :officeId and d.id NOT IN 
            (SELECT dr.desk.id FROM DeskReservation dr where dr.startDate <= :endDate AND dr.endDate >= :startDate)
            """)
    List<Desk> findAvailableDesks(@Param("officeId") Long officeId,
                                  @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
}

