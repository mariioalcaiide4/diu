import "./HeaderComponent.css";

function HeaderComponent(){
    return (
        <header className="header">
            <h1 className="title">Bienvenidos guapisimos</h1>
            <nav>
                <ul className="lista">
                    <li>
                        <a href="#">Home</a> 
                    </li>
                    <li>
                        <a href="#">Blog</a> 
                    </li>
                    <li>
                        <a href="#">News</a> 
                    </li>
                    <li>
                        <a href="#">Contact Us</a> 
                    </li>
                </ul>
            </nav>
        </header>
    )
}

export default HeaderComponent;