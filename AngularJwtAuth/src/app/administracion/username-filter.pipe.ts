import { PipeTransform, Pipe } from "@angular/core";
import { Usuario } from "../modelos/Usuario.models";


@Pipe({
    name:'usernameFilter'
})
export class UsernameFilterPipe implements PipeTransform{
   transform(usuarios:Usuario[],searchTerm: string):Usuario[]{
        if(!usuarios ||! searchTerm){
            return usuarios;

        }
        return usuarios.filter(usuario => 
            usuario.username.toLowerCase().indexOf(searchTerm.toLowerCase())!==-1);
    }
    // transform(items: Array<any>, filter: {[key: string]: any }): Array<any> {
    //     return items.filter(item => {
    //         let notMatchingField = Object.keys(filter)
    //                                      .find(key => item[key] !== filter[key]);

    //         return !notMatchingField; // true if matches all fields
    //     });
    // }
}