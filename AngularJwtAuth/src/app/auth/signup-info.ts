export class SignUpInfo {
    name: string;
    username: string;
    email: string;
    role: string;
    
enabled:boolean;
    constructor(name: string, username: string, email: string,  role: string,enabled:boolean) {
        this.name = name;
        this.username = username;
        this.email = email;       
        this.role = role;
        this.enabled=enabled;
    }
}
