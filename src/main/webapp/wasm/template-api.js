// wasm-api.js

const WasmAPI = {
    teavm: null,

    // 1. INICIALIZACIÓN
    init: async function(wasmPath) {
        console.log("Cargando Wasm...");
        this.teavm = await TeaVM.wasm.load(wasmPath);

        // Ejecutar el main de Java para inicializar estáticos
        if (this.teavm.main) {
            await this.teavm.main([]);
        }
        console.log("Wasm cargado y listo.");
    },

    // 2. TUS FUNCIONES PÚBLICAS (Aquí creas los métodos bonitos)

    saludar: function(nombre) {
        if (!this.teavm) return "Error: Wasm no cargado";

        // a) Convertir JS String -> Puntero Wasm
        const ptrEntrada = this._jsToWasm(nombre);

        // b) Ejecutar función Java (buscando en exports)
        const ptrSalida = this.teavm.instance.exports.generarSaludo(ptrEntrada);

        // c) Convertir Puntero Wasm -> JS String
        return this._wasmToJs(ptrSalida);
    },

    // 3. HERRAMIENTAS INTERNAS (PRIVADAS)
    // Estas son las que copias una vez y te olvidas de ellas para siempre

    _jsToWasm: function(jsString) {
        const ptr = this.teavm.allocateString(jsString.length);
        const memory = new Uint16Array(this.teavm.memory.buffer);
        const dataPtr = this.teavm.stringData(ptr);
        const arrayDataPtr = this.teavm.charArrayData(dataPtr);
        for (let i = 0; i < jsString.length; ++i) {
            memory[(arrayDataPtr / 2) + i] = jsString.charCodeAt(i);
        }
        return ptr;
    },

    _wasmToJs: function(ptr) {
        if (ptr === 0) return "";
        const memory = new Uint16Array(this.teavm.memory.buffer);
        const dataPtr = this.teavm.stringData(ptr);
        const arrayDataPtr = this.teavm.charArrayData(dataPtr);
        const length = this.teavm.arrayLength(dataPtr);
        let result = "";
        for (let i = 0; i < length; ++i) {
            result += String.fromCharCode(memory[(arrayDataPtr / 2) + i]);
        }
        return result;
    }
};
