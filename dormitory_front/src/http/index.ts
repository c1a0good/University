import axios from 'axios';
import {AuthResponse} from "../models/response/AuthResponse";
import {store} from "../index";


export const API_URL = `http://localhost:8083/`

const $api = axios.create({
    withCredentials: true,
    baseURL: API_URL
})

$api.interceptors.request.use((config) => {
    config.headers = {Authorization : `Bearer ${localStorage.getItem('token')}`}
    return config;
})


export default $api;