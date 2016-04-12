package ec.gob.magap.common.util;



import java.io.Serializable;
import java.util.List;

public class SearchResultDTO<x>implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -418215993968530069L;
	private Long countResults;
	private List<x> results;

	public SearchResultDTO()
	{
		this.countResults = Long.valueOf(0L);
	}

	public Long getCountResults() {
		return countResults;
	}

	public void setCountResults(Long countResults) {
		this.countResults = countResults;
	}


	public List<x> getResults() {
		return results;
	}

	public void setResults(List<x> results) {
		this.results = results;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}