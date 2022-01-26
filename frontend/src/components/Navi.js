import {Link, useNavigate} from "react-router-dom";
import "./Navi.css"

export default function Navi(){
    let navigate = useNavigate();
    return(
        <div className="navi">
            <ul>
                <li><Link to="/home">Home</Link></li>
                <li><Link to="/login">Login</Link></li>
                {/*<li><Link to="/test">Überprüfen</Link></li>*/}
            </ul>
            <button onClick={()=>navigate(-1)}>Zurück</button>
        </div>
    )
}