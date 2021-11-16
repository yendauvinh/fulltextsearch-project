package com.postgres.fulltextsearch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import java.util.UUID;


/**
 * The persistent class for the fts_one database table.
 * 
 */
@Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="fts_one")
@Data
public class FtsOne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID ftsGlobalId;

	private String description;

	private String name;

	//bi-directional many-to-one association to FtsGlobal
	@OneToMany(mappedBy="ftsOne")
	private Set<FtsGlobal> ftsGlobals;
}