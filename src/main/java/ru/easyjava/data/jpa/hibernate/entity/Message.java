package ru.easyjava.data.jpa.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Message.
 *
 * @author Ivan_Kuts
 */
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
}
