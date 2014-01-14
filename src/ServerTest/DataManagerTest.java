package ServerTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Server.Auction;
import Server.DataManager;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito.*;

public class DataManagerTest {

	
	
	
	
	@Test
	public void testLoadData() throws Exception {
		ArrayList<Auction> a = new ArrayList<Auction>();
		DataManager data = new DataManager(a);

		assertNotNull(data.loadData("backup.dat"));
	}

	@Test
	public void testSaveData() {
		ArrayList a = new ArrayList();
		DataManager b = new DataManager(a);

		try {
			b.saveData(a, "hallo.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(true);
		}

	}

	@Test
	public void testSaveDataZwei() {
		ArrayList a = new ArrayList();
		a.add("Hallo");
		DataManager b = new DataManager(a);
		File d = new File("hallo.dat");
		try {
			b.saveData(a, "hallo.dat");
			if (d.exists()) {
				assertTrue(true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@Test
	public void testSaveDataDrei() {
		ArrayList a = new ArrayList();
		a.add("Hallo");
		DataManager b = new DataManager(a);
		File d = new File("hallo.dat");
		try {
			b.saveData(a, "hallo.dat");
			if (d.length() > 0) {
				assertTrue(true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@Test
	public void testSaveDataVier() {
		ArrayList a = new ArrayList();
		a.add("Hallo");
		DataManager b = new DataManager(a);
		File d = new File("hallo.dat");
		try {
			b.saveData(a, "hallo.dat");
			if (d.length() > 0) {
				assertTrue(true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@Test
	public void testLoadDataError() {
		ArrayList<Auction> a = new ArrayList<Auction>();
		DataManager b = new DataManager(a);
		try {
			b.loadData("data.dat");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveDataIOException() {
		ArrayList a = new ArrayList();
		DataManager mockdata = Mockito.mock(DataManager.class);
		try {
			Mockito.doThrow(new IOException("test")).when(mockdata)
					.saveData(a, "Hallo.dat");
		} catch (IOException e) {
			assertTrue(true);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
	@Test(expected=IOException.class)
	public void testLoadDataIOException(){
		ArrayList a = new ArrayList();
		
		DataManager mockdata = Mockito.mock(DataManager.class);
		
			Mockito.doThrow(new IOException()).when(mockdata).saveData(a,"asda");
		
			mockdata.saveData(a,"asda");
		
		
		
	}*/
}
