package com.jdc.mkt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jdc.mkt.entity.F_FieldMapping.Days;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "collection_tbl")
public class G_CollectionMapping {

	@Id
	private int id;
	private String name;
	
	@ElementCollection
	@CollectionTable(
			name = "list_tbl",
			joinColumns = {
					@JoinColumn(name = "list_id")
			})
	@Column(name ="list_Value",length = 45)
	private List<String> lists;
	
	@ElementCollection
	@CollectionTable(
			name = "set_tbl",
			joinColumns = {
					@JoinColumn(name = "set_id")
			})
	@Column(name ="set_Value",length = 45)
	private Set<String> sets ;
	
	@ElementCollection
	@CollectionTable(
			name = "map_tbl",
			joinColumns = {
					@JoinColumn(name = "map_id")
			})
	@MapKeyColumn(name = "int_key")
	@Column(name = "map_value",length = 45)
	private Map<Integer,String> maps;
	
	@ElementCollection
	@MapKeyEnumerated(EnumType.STRING)
	@Enumerated(EnumType.STRING)
	private Map<Days, Days> days;
	
	
}
