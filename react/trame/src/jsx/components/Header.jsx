import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom"
import EntriesView from "../routes/EntriesView"
import About from "../routes/About"
import Trial from "../routes/Trial"
import HomePage from "../routes/Homepage"
function Header() {
    return (
        <>
            <header>
                <nav>
                    <Link to="/">Homepage</Link>
                    <Link to="/entries-view">Entries</Link>
                    <Link to="/about-view">About</Link>
                    <Link to="/trial">Trial</Link>
                </nav>
            </header>
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