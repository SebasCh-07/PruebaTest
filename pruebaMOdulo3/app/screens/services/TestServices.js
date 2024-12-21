export const servicioCrearBus=(post,fnExito)=>{
    const config={
        method:'POST',
        body: JSON.stringify({
                idBUS: post.idBUS,
                capMax: parseInt(post.capMax,10)
        }),
        headers: {
            'Content-type': 'application/json'
        }
    };
    fetch('http://192.168.163.153:8080/EvaluacionModuloIII-1.0.0/rest/buses/insertar',config)
    .then((response)=>{return response.json()})
    .then((json) => {console.log(json)},fnExito())
}

export const servicioCrearRuta=(post,fnExito)=>{
    const config={
        method:'POST',
        body: JSON.stringify(  {
            codigoR: post.codigoR,
            origen: post.origen,
            destino: post.destino,
            bus: {
                idBUS: post.bus.idBUS,
            }
        }),
        headers: {
            'Content-type': 'application/json'
        }
    };
    fetch('http://192.168.163.153:8080/EvaluacionModuloIII-1.0.0/rest/rutas/registrar',config)
    .then((response)=>{return response.json()})
    .then((json) => {console.log(json)},fnExito())
}

export const serviciosRecuperarRuta = () => {
    let Rutas = []
    fetch("http://192.168.163.153:8080/EvaluacionModuloIII-1.0.0/rest/rutas/recuperar").then((response) => {response.json()}).then((json) => {Rutas = json})
    return Rutas;
}