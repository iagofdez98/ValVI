import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';

const Footer = () => {
  return (
    <footer className="footer mt-auto">
      <Container>
        <hr />
        <Row>
          <Col md={12}>
            <p className="text-center">© 2024 Iago Fernández Martínez</p>
          </Col>
        </Row>
      </Container>
    </footer>
  );
};

export default Footer;
