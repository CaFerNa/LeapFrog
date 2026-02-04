// wasm-api.js

const WasmAPI = {
    teavm: null,

    // 1. INICIALIZACIÓN
    init: async function (wasmPath) {
        console.log("Cargando Wasm...");
        this.teavm = await TeaVM.wasm.load(wasmPath);

        // Ejecutar el main de Java para inicializar estáticos
        if (this.teavm.main) {
            await this.teavm.main([]);
        }
        console.log("Wasm cargado y listo.");
    },

    // 2. TUS FUNCIONES PÚBLICAS

    renderHtml: function (nombre) {
        if (!this.teavm) return "Error: Wasm no cargado";
        const ptrEntrada = this._jsToWasm(nombre);
        const ptrSalida = this.teavm.instance.exports.renderHtml(ptrEntrada);
        return this._wasmToJs(ptrSalida);
    },

    runFunction: function (fn) {
        if (!this.teavm) return "Error: Wasm no cargado";
        const result = this.teavm.instance.exports.runFunction();
        return result;
    },

    // 3. HERRAMIENTAS INTERNAS (PRIVADAS)

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
