package com.hermes.notificationservice.repositories;

import com.hermes.notificationservice.entities.Notification;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author meverg
 */
@Repository
public interface NotificationRepository extends CouchbaseRepository<Notification, Long> {
}
