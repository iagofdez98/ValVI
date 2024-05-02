import logoIcon from './logo-icon.svg';
import logoLetters from './logo-letters.svg';
import wallpaper from './fondo.jpg'

import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import './App.css';
import LoginForm from './login/login-form';

const App = ()  => {
  return (
    <div className="App">
      <Container fluid className='p-0'>
        <Row className='m-0'>
          <Col sm={5} className='p-0'>
            <img src={wallpaper} className="wallpaper" alt="logo" />
          </Col>
          <Col sm={7} className='p-0'>
            <header className="App-header">
              <div className='logos'>
                <img src={logoIcon} className="logo-icon" alt="logo" />
                <img src={logoLetters} className="logo-letters" alt="logo" />
                <p> ¡Valora tus videojuegos! </p>
              </div>
              <LoginForm/>
            </header>
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default App;
