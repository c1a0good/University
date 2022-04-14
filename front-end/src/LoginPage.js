import React, { useState,FC,useContext } from "react";
//import { useHistory } from "react-router";
import { useNavigate } from "react-router-dom";
import "./LoginPage.css";
import {Context} from './index'
import {observer} from "mobx-react-lite";

const  LoginPage = () => {

  const navigate = useNavigate();
  const {store}=useContext(Context)

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [jwt,setJwt]=useState('')

  const handleLoginChange = (e) => {
    setUsername(e.target.value)
  }

  const handlePasswordChange = (e) => {
    setPassword(e.target.value)
  }

  const handleLogIn = (e) => {
    e.preventDefault();
    setJwt(store.login(username, password,navigate))
    
  }

  return (
    <h1>
      <form className="loginForm" onSubmit={handleLogIn}>
        <h2>Авторизация</h2>
        <div>
          <input
            className="loginFormInput"
            type="text"
            placeholder="Логин"
            onChange={handleLoginChange}
            value={username}
            required
          />
        </div>
        <div>
          <input
            className="loginFormInput"
            type="password"
            placeholder="Пароль"
            onChange={handlePasswordChange}
            value={password}
            required
          />
        </div>
        <div>
          <button className="blackBtn" type="submit">
            Войти
          </button>
        </div>
      </form>
    </h1>
  );
};

export default observer(LoginPage);