package com.hegea.jwtauthentication.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.hegea.jwtauthentication.model.DayMonthYearDTO;
import com.hegea.jwtauthentication.model.FechaActividad;
import com.hegea.jwtauthentication.model.FechaActividadCompositeKey;
import com.hegea.jwtauthentication.repository.FechaActividadRepository;

public interface IFechaActividad {
	
	 List<FechaActividadCompositeKey> findAllFechaActividad();
	 void saveAll(List<FechaActividadCompositeKey> fechaActividadList);
	 void deleteFechaActividad(FechaActividadCompositeKey fechaActividad);
	 List<FechaActividadCompositeKey> findAllFechaActividadOrdenada();
	 List<FechaActividadCompositeKey> findAllFechaActividadDesdeHoy();
	 public List<FechaActividad> extraerSemanaMes(DayMonthYearDTO dayMonthYearDTO);
	 public  List<FechaActividad>  extraerDiasMes(int year,String mes,DayOfWeek dia,String actividad);
	 @Service
	    public class FechaActividadClass implements IFechaActividad{
@Autowired
FechaActividadRepository fechaActividad;
		@Override
		public List<FechaActividadCompositeKey> findAllFechaActividad() {
			// TODO Auto-generated method stub
			return fechaActividad.findAll();
		}
		@Override
		public void saveAll(List<FechaActividadCompositeKey> fechaActividadList) {
			fechaActividad.saveAll(fechaActividadList);
			
		}
		@Override
		public void deleteFechaActividad(FechaActividadCompositeKey fechaActividad) {
			this.fechaActividad.delete( fechaActividad);
			
		}
//		@Override
		public List<FechaActividadCompositeKey> findAllFechaActividadOrdenada() {
			// TODO Auto-generated method stub
			return fechaActividad.findAllFechaActividadOrderByFecha();
		}
		@Override
		public List<FechaActividadCompositeKey> findAllFechaActividadDesdeHoy() {
			// TODO Auto-generated method stub
			return this.fechaActividad.findAllFechaActividadDesdeHoy();
		}
		@Override
		public List<FechaActividad> extraerSemanaMes(DayMonthYearDTO dayMonthYearDTO){
			 List<FechaActividad>  extraerSemanaMesFechaActividadList = new ArrayList<>();
			 if (dayMonthYearDTO.getLunes()) {
				 extraerSemanaMesFechaActividadList.addAll(extraerDiasMes(dayMonthYearDTO.getYear(),dayMonthYearDTO.getMes(),DayOfWeek.MONDAY,dayMonthYearDTO.getActividad()));
			 }
			 if (dayMonthYearDTO.getMartes()) {
				 extraerSemanaMesFechaActividadList.addAll(extraerDiasMes(dayMonthYearDTO.getYear(),dayMonthYearDTO.getMes(),DayOfWeek.TUESDAY,dayMonthYearDTO.getActividad()));
			 }
			 if (dayMonthYearDTO.getMiercoles()) {
				 extraerSemanaMesFechaActividadList.addAll(extraerDiasMes(dayMonthYearDTO.getYear(),dayMonthYearDTO.getMes(),DayOfWeek.WEDNESDAY,dayMonthYearDTO.getActividad()));
			 }
			 if (dayMonthYearDTO.getJueves()) {
				 extraerSemanaMesFechaActividadList.addAll( extraerDiasMes(dayMonthYearDTO.getYear(),dayMonthYearDTO.getMes(),DayOfWeek.THURSDAY,dayMonthYearDTO.getActividad()));
			 }
			 if (dayMonthYearDTO.getViernes()) {
				 extraerSemanaMesFechaActividadList.addAll(extraerDiasMes(dayMonthYearDTO.getYear(),dayMonthYearDTO.getMes(),DayOfWeek.FRIDAY,dayMonthYearDTO.getActividad()));
			 }
			 return extraerSemanaMesFechaActividadList;
			 
		 }
		@Override
		 public  List<FechaActividad>  extraerDiasMes(int year,String mes,DayOfWeek dia,String actividad) {
				
				
			 List<FechaActividad>  FechaActividadextraerDiasMes = new ArrayList<>();
			 Month month = Month.valueOf(mes.toUpperCase());
		        LocalDate date = Year.of(year).atMonth(month).atDay(1).
		              with(TemporalAdjusters.firstInMonth(dia));
		        Month mi = date.getMonth();
		        while (mi == month) {
		        	 FechaActividad extraerDiasMesfechaActividadDTO = new FechaActividad();
		        	extraerDiasMesfechaActividadDTO.setFecha(java.sql.Date.valueOf(date));
		        	extraerDiasMesfechaActividadDTO.setNombre_act(actividad);
		        	FechaActividadextraerDiasMes.add(extraerDiasMesfechaActividadDTO);
		            date = date.with(TemporalAdjusters.next(dia));
		            mi = date.getMonth();
		        }
		        return FechaActividadextraerDiasMes;
		 }

		 
		
	 }
}
