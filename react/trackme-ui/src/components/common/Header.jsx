import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom"
import HomePage from "../../pages/HomePage"
import EntriesView from "../../pages/EntriesView"
import About from "../../pages/About"
import Trial from "../../pages/Trial"
import './common.css'
function Header() {
    return (
        <>
                <nav className="navbar">
                    <div className="logo">TrackMe</div>
                    <div className="nav-links">
                        <Link to="/">Homepage</Link>
                        <Link to="/entries-view">Entries</Link>
                        <Link to="/about-view">About</Link>
                        <Link to="/trial">Trial</Link>
                    </div>
                </nav>
            <Routes>
                <Route path="/" element={<HomePage />}></Route>
                <Route path="/entries-view" element={<EntriesView />}></Route>
                <Route path="/about-view" element={<About />}></Route>
                <Route path="/trial" element={<Trial />}></Route>
            </Routes>
        </>
    )
}

export default Header