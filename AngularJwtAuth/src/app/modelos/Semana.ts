export class Semana{
    
    public year:number;
    public mes:string;
    public actividad:string;
    public lunes:Boolean;
    public martes:Boolean;
    public miercoles:Boolean;
    public jueves:Boolean;
    public viernes:Boolean;
    
    
    

    constructor(year,mes,actividad,lunes,martes,miercoles,jueves,viernes){
            this.lunes=lunes
            this.martes=martes
            this.miercoles=miercoles
            this.jueves=jueves
            this.viernes=viernes
            this.year=year
            this.actividad=actividad
            this.mes=mes
    }
   
        
        
        
}

     