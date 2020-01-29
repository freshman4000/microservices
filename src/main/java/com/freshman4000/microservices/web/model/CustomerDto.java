package com.freshman4000.microservices.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    private String name;
}
