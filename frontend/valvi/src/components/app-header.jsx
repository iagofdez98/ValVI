import React from 'react';
import "./app-header.css";
import Button from '@mui/material/Button';
import { Navbar, Nav } from 'react-bootstrap';
import logo from "../images/logo-valvi.png"
import Searcher from './searcher';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';

const Header = ({ username, games = []}) => {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);

    const handleImageClick = () => {
        window.location.href = '/home';
    };

    const handleClick = (event) => {
      setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
      localStorage.removeItem('auth_token');
      refreshPage();
    };

    const refreshPage = () => {
      window.location.reload();
    }

    return (
        <Navbar bg="dark" variant="dark" expand="lg" className='custom-navbar' fixed="top">
            <img src={logo} onClick={handleImageClick} alt="Valvi" className="logo-blue"/>
            <Navbar.Brand onClick={handleImageClick}>ValVi</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="responsive-navbar-nav">
                <Nav className="me-auto">
                    <Nav.Link href="/games">Tus juegos</Nav.Link>
                    <Nav.Link href="/reviews">Reviews</Nav.Link>
                    <Nav.Link href="/lists">Listas</Nav.Link>
                </Nav>
                <Nav>
                    <Searcher games={games}/>
                    <Nav.Link className='pr-4'>
                      <div>
                        <div
                          id="basic-button"
                          onClick={handleClick}
                        >
                          {username}
                        </div>
                        <Menu
                          id="basic-menu"
                          anchorEl={anchorEl}
                          open={open}
                          onClose={handleClose}
                        >
                          <MenuItem onClick={handleClose}>Logout</MenuItem>
                        </Menu>
                      </div>
                    </Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
}

export default Header;
