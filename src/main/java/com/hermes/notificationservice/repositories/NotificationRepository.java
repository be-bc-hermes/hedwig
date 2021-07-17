package com.hermes.notificationservice.repositories;

import com.hermes.notificationservice.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author meverg
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
