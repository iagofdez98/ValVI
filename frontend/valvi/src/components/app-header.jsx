import React from 'react';
import "./app-header.css";
import { Navbar, Nav, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import logo from "../images/logo-valvi.png"

const Header = () => {
    const handleImageClick = () => {
        window.location.href = '/home';
    };

    return (
        <Navbar bg="dark" variant="dark" expand="lg" className="pl-3">
            <Container>
                <img src={logo} onClick={handleImageClick} alt="Valvi" className="logo-blue"/>
                <Navbar.Brand onClick={handleImageClick}>ValVi</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                    <Nav.Link href="#link">Link</Nav.Link>
                    <Nav.Link href="#about">About</Nav.Link>
                    <Nav.Link href="#contact">Contact</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default Header;
