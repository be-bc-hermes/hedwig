package com.hermes.notificationservice.repositories;

import com.hermes.notificationservice.entities.Notification;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author meverg
 */
@Repository
public interface NotificationRepository extends CouchbaseRepository<Notification, Long> {
    Optional<Notification> findById(String id);
}
