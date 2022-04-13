
import {makeAutoObservable} from "mobx";
import AuthService from "../services/AuthService";
import axios, { Axios } from 'axios';
import {AuthResponse} from "../models/response/AuthResponse";
import {API_URL} from "../http";
import { NavigateFunction, useNavigate } from "react-router-dom";

export default class Store {
    isAuth = false;
    isLoading = false;

    constructor() {
        makeAutoObservable(this);
    }

    setAuth(bool: boolean) {
        this.isAuth = bool;
    }


    setLoading(bool: boolean) {
        this.isLoading = bool;
    }

   async  login(login: string, password: string,navigate: NavigateFunction) {
        try {
            const response = await AuthService.login(login, password);
            console.log(response.data)
            localStorage.setItem('token', response.data.access_token);
            this.setAuth(true);
            navigate("/resident_list")
        } catch (e: unknown) {
            navigate("/login")
            console.log("e.response?.data?.message");
        }
    }

    async registration(email: string, password: string) {
        try {
            const response = await AuthService.registration(email, password);
            console.log(response)
            localStorage.setItem('token', response.data.access_token);
            this.setAuth(true);
        } catch (e) {
            console.log("e.response?.data?.message");
        }
    }

    async logout() {
        try {
            // const response = await AuthService.logout();
            localStorage.removeItem('token');
            this.setAuth(false);
        } catch (e) {
            console.log("e.response?.data?.message");
        }
    }

    async checkAuth() {
        this.setLoading(true);
        try {
            const response = await axios.get<AuthResponse>(`${API_URL}/refresh`, {withCredentials: true})
            console.log(response);
            localStorage.setItem('token', response.data.access_token);
            this.setAuth(true);
        } catch (e) {
            console.log("e.response?.data?.message");
        } finally {
            this.setLoading(false);
        }
    }
}