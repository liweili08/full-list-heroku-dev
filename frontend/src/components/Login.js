import Header from "./Header";
import Navi from "./Navi";
import "./Login.css"

export default function Login(){
    return(
        <div className="loginPage">
            <h1> Anmelden </h1>
            <form className="Info">
                <label for="username"> Username: </label>
                <input type="text"
                       id="username"
                       name="username"
                />

                <label for="password"> Password: </label>
                <input type="password"
                       id="pass"
                       name="password"
                       placeholder="6-8 Zeichen"
                       minLength="6"
                       maxLength="8"
                       size="20"
                />
            </form>
            <input type="submit" value="Sign in"/>
            <Navi/>
        </div>

    )
}


