package ke.co.greid.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import ke.co.greid.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("countryDAO")
public class CountryDAOImpl implements ICountryDAO{
	private NamedParameterJdbcTemplate jdbc;
	
	
	
	public CountryDAOImpl() {
		System.out.println("Successfully loaded the Country DAO");
	}

	//@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc=new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Country> getCountries(){
		return jdbc.query("select * from countries", new RowMapper<Country>() {

			@Override
			public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
				Country country=new Country();
				country.setId(rs.getInt("id"));
				country.setName(rs.getString("name"));
				return country;
			}
		});
	}
	

	public boolean update(Country country){
		
		BeanPropertySqlParameterSource params=new BeanPropertySqlParameterSource(country);
		return jdbc.update("update countries set name= :name", params)==1;
		
	}
	
	public boolean create(Country country){
		BeanPropertySqlParameterSource params=new BeanPropertySqlParameterSource(country);
		return jdbc.update("insert into countries(name) values (:name)", params)==1;
		
	}
	
	public boolean delete(int id){
		return false;
	}
	
	public Country getCountry(int id){
		MapSqlParameterSource params=new MapSqlParameterSource("id", id);
		return jdbc.queryForObject("select * from  countries where id=:id", params, new RowMapper<Country>() {

			@Override
			public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
				Country country=new Country();
				country.setId(rs.getInt("id"));
				country.setName(rs.getString("name"));
				return null;
			}
		});
		
	}
}
