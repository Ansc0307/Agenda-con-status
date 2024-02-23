package Clases;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Registro{
    private ArrayList<Tarea> tareas;

	public Registro() {
		this.tareas = new ArrayList<>();

	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
	
	public void addTarea(Tarea tarea) {
		tareas.add(tarea);
		
	}

	@Override
	public String toString() {
		String s = "";
		for(Tarea t: tareas) {
			s += t.toString();
		}
		return s;
	}
	
	
	
	public String getPendientes(){
		String s = "";
		for(Tarea t: tareas) {
			if(t.getEstado().equals("Pendiente")) {
				s += t.toString();
			}
			
		}
		return s;
	}
	public String getEnCurso(){
		String s = "";
		for(Tarea t: tareas) {
			if(t.getEstado().equals("En Curso")) {
				s += t.toString();
			}
			
		}
		return s;
	}
	
	public String getCompletada(){
		String s = "";
		for(Tarea t: tareas) {
			if(t.getEstado().equals("Completada")) {
				s += t.toString();
			}
			
		}
		return s;
	}
	
	public void eliminarTarea(String nombre) {
		ArrayList<Tarea> copia = new ArrayList<>();
		for(Tarea t:tareas) {
			if(!t.getNombre().equals(nombre)) {
				copia.add(t);
			}
		}
		this.tareas = copia;
	}
	
	public void cambiarEstado(String nombre,String estado) {
		for(Tarea t:tareas) {
			if(t.getNombre().equals(nombre)) {
				if(estado.equals("Pendiente")) {
					t.setPendiente();
				}
				if(estado.equals("Completada")) {
					t.setCompletado();
				}
				if(estado.equals("En Curso")) {
					t.setEnCurso();
				}
			}
		}
		
	}
	
	
	public ArrayList<String> listaNombresNuevos(){
		ArrayList<String> nombres = new ArrayList<>();
		for(Tarea t:tareas) {
			if(t.getEstado().equals("Pendiente")) {
				nombres.add(t.getNombre());
			}
		}
		return nombres;
	}
	
	
	public ArrayList<String> listaNombres(){
		ArrayList<String> nombres = new ArrayList<>();
		for(Tarea t:tareas) {
			nombres.add(t.getNombre());
		}
		return nombres;
	}
	
	public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Tarea tarea : tareas) {
                writer.write(tarea.toString());
                writer.newLine(); // Agregar una nueva línea entre cada tarea
            }
            System.out.println("Todas las tareas guardadas en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
	public ArrayList<Tarea> buscarTareasPorEstado(String estado) {
        ArrayList<Tarea> tareasFiltradas = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.getEstado().equalsIgnoreCase(estado)) {
                tareasFiltradas.add(tarea);
            }
        }
        return tareasFiltradas;
    }
	
	
	

	
    
}