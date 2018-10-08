package entity;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Before;
import org.junit.Test;

public class SolrJTestTest {

	 SolrJTest solr = null;
	@Before
	public void before() {
		solr=new SolrJTest();
	}
	
	@Test
	public void testCreateSolrServer() throws Exception {
		solr.addDoc();
		solr.querySolr();
	}

	@Test
	public void testAddDoc() {
		System.out.println("666");
	}

	
	public void testDeleteDocumentById() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuerySolr() {
		fail("Not yet implemented");
	}

}
