import $api from "../http";
import {AxiosResponse} from 'axios';
import {AuthResponse} from "../models/response/AuthResponse";

export default class AuthService {
    static async login(name: string, pass: string): Promise<AxiosResponse<AuthResponse>> {
        const form=new FormData()
        form.append("username",name)
        form.append("password",pass)
        const JWT=await $api.post<AuthResponse>('/login/',form)
        return JWT
    }

    static async registration(login: string, password: string): Promise<AxiosResponse<AuthResponse>> {
        const form=new FormData()
        form.append("username",login)
        form.append("password",password)
        return $api.post<AuthResponse>('/registration/',form)
    }

    static async logout(): Promise<void> {
        return $api.post('/logout/')
    }

}