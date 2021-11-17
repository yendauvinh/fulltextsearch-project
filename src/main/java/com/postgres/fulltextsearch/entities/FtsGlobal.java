package com.postgres.fulltextsearch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


/**
 * The persistent class for the fts_global database table.
 * 
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fts_global")
@Data
public class FtsGlobal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID ftsGlobalId;

	@Column(name="description")
	private String description;

	@Column(name="name")
	private String name;

	@Column(name="fts_one_id")
	private UUID ftsOneId;

	private String status;
	private java.util.Date created;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fts_one_id", insertable = false, updatable = false)
	private FtsOne ftsOne;
}