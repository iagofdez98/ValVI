import React from 'react';
import "./app-header.css";
import { Navbar, Nav, Container } from 'react-bootstrap';
import logo from "../images/logo-valvi.png"

const Header = () => {
    return (
        <Navbar bg="dark" variant="dark" expand="lg" className="pl-3">
            <Container>
                <img src={logo} href="#home" alt="Valvi" className="logo-blue"/>
                <Navbar.Brand href="#home">ValVi</Navbar.Brand>
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
