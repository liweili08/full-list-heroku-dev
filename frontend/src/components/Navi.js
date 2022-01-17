import {Link, useNavigate} from "react-router-dom";
import "./Navi.css"

export default function Navi(){
    let navigate = useNavigate();
    return(
        <div className="navi">
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/change">Änderung</Link></li>
                <li><Link to="/test">Überprüfen</Link></li>
            </ul>
            <button onClick={()=>navigate(-1)}>Zurück</button>
        </div>
    )
}