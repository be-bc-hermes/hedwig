package com.hermes.notificationservice.repositories;

import com.hermes.notificationservice.entities.Notification;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

/**
 * @author meverg
 */
public interface NotificationRepository extends CouchbaseRepository<Notification, Long> {
}
