import React from 'react';
import "./app-header.css";
import { Navbar, Nav } from 'react-bootstrap';
import logo from "../images/logo-valvi.png"
import Searcher from './searcher';

const Header = ({ username, games = []}) => {
    const handleImageClick = () => {
        window.location.href = '/home';
    };

    return (
        <Navbar bg="dark" variant="dark" expand="lg" className='custom-navbar' fixed="top">
            <img src={logo} onClick={handleImageClick} alt="Valvi" className="logo-blue"/>
            <Navbar.Brand onClick={handleImageClick}>ValVi</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="responsive-navbar-nav">
                <Nav className="me-auto">
                    <Nav.Link href="/games">Tus juegos</Nav.Link>
                    <Nav.Link href="#about">About</Nav.Link>
                    <Nav.Link href="#contact">Contact</Nav.Link>
                </Nav>
                <Nav>
                    <Searcher games={games}/>
                    <Nav.Link className='pr-4'>{username}</Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
}

export default Header;
