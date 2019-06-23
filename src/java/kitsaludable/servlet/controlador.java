package kitsaludable.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kitsaludable.componentes.alimentos;
import kitsaludable.sistema.fabrica_BBDD;

public class controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        
        String dieta;
        fabrica_BBDD fb = new fabrica_BBDD();
        List<alimentos> alimentos_delControlador;
        RequestDispatcher rd = null;
        
        if(request.getParameter("boton")!= null){
            dieta = request.getParameter("opcion");
            alimentos_delControlador = fb.getAlimentos(dieta);
            
            request.setAttribute("lista dietas", alimentos_delControlador);
            rd= request.getRequestDispatcher("/alimentos.jsp");
        }
        
        rd.forward(request, response);
        
        
        
    }
}
    /*
    private fabrica_BBDD fabricaAlimentos;
  
    @Override
    public void init()throws ServletException{
        super.init(); 
        try{
            fabricaAlimentos= new fabrica_BBDD();
        }catch(Exception e){
            throw new ServletException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        //Obtener las lista de alimentos desde fabrica
        List<alimentos> alimentos_delControlador;
        try{
            alimentos_delControlador=fabricaAlimentos.getAlimentos();
        
        //agregar la lista de alimentos al request
        
            request.setAttribute("Lista_Alimentos", alimentos_delControlador);
        //enviar ese request a el jsp
            
            RequestDispatcher miDispatcher=request.getRequestDispatcher("/alimentos.jsp");
            
            miDispatcher.forward(request, response);
            
            }catch(Exception e){
            e.printStackTrace();
        }
    }


}
*/