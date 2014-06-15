package Model;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.Vector;

public class Cancion extends BDHandler{
	
	public int m_identificador;
	public String m_nombre;
	public String m_letra;
	public String m_url;
	public String m_artista;
	public String m_categoria;

	public int m_id_usuario;
	public int m_id_artista;
	public int m_id_categoria;
	
	public Cancion(){
		super();
	}
	
	public void ListarDetalleCancion(int id_can){
		
		try{
			 //Vector<String> data = new  Vector<String>();
    		
    		this.m_conn.setAutoCommit(false);
    		this.m_proc = null;
    		this.m_proc = m_conn.prepareCall("{ call fx_listar_detalle_cancion (?,?) }");
    		
    		//seteamos los parametros, el primer parametro es po defecto el cursor
    		this.m_proc.setNull(1, Types.OTHER);
    		this.m_proc.registerOutParameter(1, Types.OTHER);
    		this.m_proc.setInt(2, id_can);  
    		
    		this.m_proc.execute();
    		
    		//para el caso de nuestro cursosr, solo tenemos uno en nuestra funcion
    		this.m_result = null;
    		this.m_result = (ResultSet) m_proc.getObject(1);
    		this.m_result_metada = m_result.getMetaData();
    		while (m_result.next()) {
    			//data.add(m_result.getString("nom_can"));
    			//data.add(m_result.getString("let_can"));
    			//data.add(m_result.getString("url_can"));   
    			//data.add(m_result.getString("nom_art"));   
    			//data.add(m_result.getString("nom_cat")); 
    			this.m_identificador	= id_can;
    			this.m_nombre 			= m_result.getString("nom_can");
    			this.m_letra 			= m_result.getString("let_can");
    			this.m_url 				= m_result.getString("url_can");
    			this.m_artista 			= m_result.getString("nom_art");
    			this.m_categoria 		= m_result.getString("nom_cat");
    		}
    		this.m_result.close();
    		
    		this.m_conn.commit();
			this.m_conn.setAutoCommit(true);
    		
    		this.m_proc.close();    		    		
			
		}catch (Exception e) {
            System.err.println("El porque del cascar SQL: " + e.getMessage());
            e.printStackTrace();
        }		
		
	}
	
	public void AgregarCancion(){
		
		try{
			 //Vector<String> data = new  Vector<String>();
			int result = -1 ;
    		this.m_conn.setAutoCommit(false);
    		this.m_proc = null;
    		this.m_proc = m_conn.prepareCall("{ call fx_cancion_registrar (?,?,?,?,?,?,?) }");
    		
    		
    		//seteamos los parametros, el primer parametro es po defecto el cursor
    		this.m_proc.setString(1, this.m_nombre);			
			this.m_proc.setString(2, this.m_letra);
			this.m_proc.setString(3, this.m_url);
			this.m_proc.setInt(4, this.m_id_artista);
			this.m_proc.setInt(5, this.m_id_categoria);
			this.m_proc.setInt(6, this.m_id_usuario);
			this.m_proc.registerOutParameter(7, Types.INTEGER); //el parametro de salida
			
			this.m_proc.execute();
			
			result = this.m_proc.getInt(7);
			
    		    		
    		this.m_conn.commit();
			this.m_conn.setAutoCommit(true);
    		
    		this.m_proc.close();    		    		
			
		}catch (Exception e) {
            System.err.println("El porque del cascar SQL: " + e.getMessage());
            e.printStackTrace();
        }		
		
	}


}
